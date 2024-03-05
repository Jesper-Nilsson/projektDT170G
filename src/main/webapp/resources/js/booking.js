document.addEventListener("DOMContentLoaded", function() {
    // Get all elements with the class "test"
    const buttons = document.querySelectorAll('.guestAmountBtn');

    // Loop through each button
    buttons.forEach(function(button) {
        // Add event listener for click event
        button.addEventListener('click', function() {
            openModal(2);
            closeModal(1);
        });
    });
});

// Function to open a modal
function openModal(modalId) {
    const modal = document.getElementById("modalStep" + modalId);
    modal.style.display = 'block';
    modal.setAttribute('aria-hidden', 'false');
    document.body.classList.add('modal-open'); // Add class to body
    document.documentElement.style.overflow = 'hidden'; // Prevent scrolling on html element
}

// Function to close a modal
function closeModal(modalId) {
    const modal = document.getElementById("modalStep" + modalId);
    modal.style.display = 'none';
    modal.setAttribute('aria-hidden', 'true');

    // Check if any modals are still open
    const modals = document.querySelectorAll('.modal')
    let isOpen = false;

    modals.forEach(modal => {
        if (modal.style.display === 'block') {
            isOpen = true;
        }
    });

    if (!isOpen) {
        document.body.classList.remove('modal-open'); // Remove class from body if no modals are open
        document.documentElement.style.overflow = 'hidden scroll'; // Restore scrolling on html element
    }
}




// Event listener for booking button
document.getElementById('bookingButton1').addEventListener('click', function() {
    openModal('1');
});

document.getElementById('bookingButton2').addEventListener('click', function() {
    openModal('1');
});

function validateDateTimeInputs() {
    // Get references to the input elements
    var dateInput = document.getElementById("j_idt17:datePicker_input");
    var timeInput = document.getElementById("j_idt17:timePicker_input");

    // Check if the inputs are empty
    var dateIsEmpty = dateInput.value.trim() === '';
    var timeIsEmpty = timeInput.value.trim() === '';

    // If both date and time are required fields
    if (dateIsEmpty || timeIsEmpty) {
        return false; // Return false if either date or time is empty
    } else {
        return true; // Return true if both date and time are provided
    }
}

function validateNamePhone() {
    const nameInput = document.getElementById('j_idt17:userName');
    const phoneInput = document.getElementById('j_idt17:userPhone');

    if (nameInput.value.trim() === '' || phoneInput.value.trim() === '') {
        // If either field is empty, disable the submit button and prevent form submission
        return false;
    } else {
        // Validate phone number format
        const phoneNumber = phoneInput.value.trim();
        const phoneNumberRegex = /^(?:\d{10}|\d{3}-\d{3} \d{2} \d{2}|\d{3}-\d{7}|\d{3} \d{3} \d{2} \d{2})$/;
        if (!phoneNumberRegex.test(phoneNumber)) {
            return false; // Prevent form submission if phone number format is incorrect
        }

        // If both fields are filled and the phone number format is correct, allow form submission
        return true;





    }
}

// Event listener for choosing number of guests
document.getElementById('chooseDateTime').addEventListener('click', function() {
    if (validateDateTimeInputs()) {
        openModal('3');
        closeModal('2');
    } else {
        showInvalidDateInput();
    }
});

// This function is triggered when the "Checka Info" button is clicked
function checkInfoAndProceed() {
    if (validateNamePhone()) {
        closeModal('3'); // Close the current modal (Step 3)
        openModal('4'); // Open the next modal (Step 4 for confirmation)
       document.getElementById('j_idt17').disabled = false; // Assuming 'j_idt17' needs to be enabled
        document.getElementById('invalidNamePhoneInput').style.display = "none";
    } else {
        //document.getElementById('j_idt17').disabled = true;
        document.getElementById('invalidNamePhoneInput').style.display = "block";
    }
}

// Attach the function to the button's click event
document.getElementById('checkInfoButton').addEventListener('click', function() {
    // Perform validation
    if (validateNamePhone()) {
        closeModal('3');
        document.getElementById('j_idt17').disabled = false;
        document.getElementById('invalidNamePhoneInput').style.display = "none";
        document.getElementById('j_idt17:saveBooking').form.submit();
        document.getElementById('j_idt17:saveBooking').form.reset();
        openModal("4");
    } else {
        document.getElementById('j_idt17').disabled = true;
        document.getElementById('invalidNamePhoneInput').style.display = "block";
    }
});

// Function to navigate back to the previous modal
function goBackModal(currentModalId, previousModalId) {
    closeModal(currentModalId);
    openModal(previousModalId);
}

function showMoreThanSixInfo() {
    const moreThanSixInfo = document.getElementById("moreThanSixInfo");
    moreThanSixInfo.style.display = "block";
}

function showInvalidDateInput() {
    const moreThanSixInfo = document.getElementById("invalidDateTimeInput");
    moreThanSixInfo.style.display = "block";
}
////////

