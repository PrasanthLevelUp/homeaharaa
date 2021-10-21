package com.homeaharaa.TestBase;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static String dest;
    public static String time;
    public static ExtentReports report;
    public static ExtentTest test;
    public static FileReader propreader;
    public static Properties prop;
    public static WebDriver driver;
    public static FileInputStream excelinputStream;
    public static FileOutputStream exceloutputStream;
    public static File excelfile;
    public static XSSFWorkbook Workbook = null;
    public static XSSFSheet sheet = null;
    public static HashMap<String, String> cellvalues;
    public static int RowNo;
    public static String RunningTCName;

    public static String takeScreenshot(WebDriver driver) {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
            Date date = new Date();
            time = dateFormat.format(date);
            TakesScreenshot tc = (TakesScreenshot) driver;
            File src = tc.getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/Screenshot/" + time + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(src, destination);
        } catch (Exception ex) {
        }
        return dest;
    }

    @BeforeTest(groups = {"Regression"})
    public void Reportsetup() {
        try {
            this.loadpropertyfile();
            report = new ExtentReports("./ExtentReport/Report.html", true);
            report.addSystemInfo("HostName", "mycustomgun").addSystemInfo("Environment", "Dev")
                    .addSystemInfo("User", "Automation").addSystemInfo("Project Name", "mycustomgun.com");
            report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

            //FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "\\Screenshot"));
            this.readfile();
        } catch (Exception ex) {
            System.out.println("Issue is" + ex.getMessage());
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void getReport(ITestResult result) {
        try {
            String screnshotpath = takeScreenshot(driver);
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(LogStatus.FAIL, result.getThrowable());
                test.log(LogStatus.FAIL, "Test Case is Fail:- " + result.getName());
                test.log(LogStatus.FAIL, "Final Screen Shot:-" + test.addScreenCapture(screnshotpath));
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(LogStatus.PASS, "Test Case Pass is:- " + result.getName());
                test.log(LogStatus.PASS, "Final Screen Shot:-" + test.addScreenCapture(screnshotpath));
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(LogStatus.SKIP, "Test Case Skip");
            } else if (result.getStatus() == ITestResult.STARTED) {
                test.log(LogStatus.INFO, "Test Case started");
            }
            report.endTest(test);
        } catch (Exception es) {
            System.out.println(" Report genration Excepion is:- " + es.getMessage());
        }
    }

    @AfterTest(groups = {"Regression"})
    public void endTest() {
        report.flush();
        report.close();
    }

    public static WebDriver startBrowser(String browsername, String url) {
        if (browsername.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("Headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            // options.addArguments("screenshot");
            // options.addArguments("window-size=1980,960");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        }
        driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public String getData(String columnName) {
        if (cellvalues.containsKey(columnName)) {
            return cellvalues.get(columnName);
        } else {
            return null;
        }
    }

    public void setData(String columnName, String value) throws IOException {
        if (cellvalues.containsKey(columnName)) {
            cellvalues.put(columnName, value);
            for (int i = 1; i < sheet.getRow(0).getLastCellNum(); i++) {
                if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                    sheet.getRow(RowNo).createCell(i).setCellValue(value);
                    writefile();
                    break;
                }
            }
        } else {
        }
    }

    public void loadpropertyfile() throws IOException {
        propreader = new FileReader("./src/main/resources/config.properties");
        prop = new Properties();
        prop.load(propreader);
    }

    public void writefile() throws IOException {
        FileOutputStream outFile = new FileOutputStream(excelfile);
        Workbook.write(outFile);
        outFile.close();
    }

    public void readfile() {

        String filePath = System.getProperty("user.dir") + "/src/main/resources/SellingPRICEOFEACHPRODUCT Full.xlsx";
        excelfile = new File(filePath);
        try {
            excelinputStream = new FileInputStream(excelfile);
            Workbook = new XSSFWorkbook(excelinputStream);
            sheet = Workbook.getSheet(prop.getProperty("sheetname"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, String> getDatas(String TCName) {
        RunningTCName = TCName;
        cellvalues = new HashMap<String, String>();
        RowNo = 0;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TCName)) {
                RowNo = i;
                break;
            }
        }
        for (int i = 1; i < sheet.getRow(0).getLastCellNum(); i++) {
            try {
                cellvalues.put(sheet.getRow(0).getCell(i).getStringCellValue(),
                        sheet.getRow(RowNo).getCell(i).getRawValue());
                System.out.println(sheet.getRow(0).getCell(i).getStringCellValue() + " "
                        + sheet.getRow(RowNo).getCell(i).getRawValue());
            } catch (Exception e) {
                cellvalues.put(sheet.getRow(0).getCell(i).getStringCellValue(), null);
            }
        }
        return cellvalues;
    }

    public static ArrayList<HashMap<String, String>> readExcelUsingFillo(String fileName, String Query) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/";

        ArrayList<HashMap<String,String>> ar=new ArrayList<>();
        try {
            Fillo fillo = new Fillo();
            Connection connection = null;
            connection = fillo.getConnection(filePath+fileName);
            Recordset recordset = null;
            recordset = connection.executeQuery(Query);
            while (recordset.next()){
                HashMap<String,String> hm=new LinkedHashMap<>();
                for (String coloumname:recordset.getFieldNames()) {
                    hm.put(coloumname,recordset.getField(coloumname));
                }
                ar.add(hm);
            }

			recordset.close();
			connection.close();
            return ar;

        } catch (FilloException e) {
            e.printStackTrace();
        }
        return null;
    }

}
