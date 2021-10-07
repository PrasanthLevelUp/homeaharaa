  $(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your first name'
                    }
                }
            },
             last_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },

				 Cust_Name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply  Customer name'
                    }
                }
            },

				 Sorce_acc: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply  Source Account No.'
                    }
                }
            },

				 Dest_acc: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply  Destination Account No.'
                    }
                }
            },

				 amount: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply  Amount.'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 4
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
				 title: {
                validators: {
                    notEmpty: {
                        message: 'Please select Title'
                    }
                }
            },

				 Source_bank: {
                validators: {
                    notEmpty: {
                        message: 'Please select Soruce Bank'
                    }
                }
            },
			Dest_bank: {
                validators: {
                    notEmpty: {
                        message: 'Please Destination Bank'
                    }
                }
            },

            zip: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    },
                    zipCode: {
                       
                        message: 'Please supply a vaild zip code'
                    }
                }
            },

			username: {
                validators: {
                    notEmpty: {
                        message: 'Please supply username'
                    },
                    username: {
                       
                        message: 'Please supply a username'
                    }
                }
            },
		password: {
                validators: {
                    notEmpty: {
                        message: 'Please supply Passcode'
                    },
                    password: {
                       
                        message: 'Please supply Passcode'
                    }
                }
            },

            comment: {
                validators: {
                      stringLength: {
                        min: 2,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description of your project'
                    }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
           // $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});