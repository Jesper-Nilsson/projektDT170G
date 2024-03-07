

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
/*
document.getElementById('j_idt17:saveBooking').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent the default form submission behavior
    // ... your existing code to capture values and validate them

    if (validateNamePhone()) {
        // Assuming this part populates and shows the confirmation
        let userName = document.getElementById('j_idt17:userName').value;
        let userPhone = document.getElementById('j_idt17:userPhone').value;
        document.getElementById('bookingDetails').innerText = "Bokningen sparades på namnet: \n" + userName + ", med telefonnummer: " + userPhone;
        openModal('4'); // Show the modal with booking details

        // Set a timer to hide the modal or clear the message after 10 seconds
        setTimeout(() => {
            closeModal('3'); // Hide the confirmation modal
            // Or clear the message without closing if you prefer
            // document.getElementById('bookingDetails').innerText = '';
            closeModal('4'); // Hide the confirmation modal
        }, 10000); // 10000 milliseconds = 10 seconds

        // Your code to submit the form data (AJAX call or form.submit() if needed)
    } else{
        document.getElementById('invalidNamePhoneInput').style.display = "block";
    }
});
*/
document.getElementById('j_idt17:saveBooking').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent the default form submission behavior
    // Assuming you have an AJAX call here that submits the booking and updates part of the page

    // Use a brief timeout to allow the AJAX response to update the page
   // setTimeout(() => {
        const messageArea = document.getElementById('bookingMessageArea');
        const limitMessage = messageArea.querySelector('.limit-message');

        // Check if the limit message is displayed and contains text
        if (limitMessage && limitMessage.innerHTML.trim() !== '') {
            // Booking limit reached, show the error message and do not open the confirmation modal
            alert(limitMessage.innerHTML); // Or use a more user-friendly way to display the message
        } else {
            // Booking was successful, proceed with showing the confirmation
            let userName = document.getElementById('j_idt17:userName').value;
            let userPhone = document.getElementById('j_idt17:userPhone').value;
            document.getElementById('bookingDetails').innerText = "Bokningen sparades på namnet: " + userName + ", med telefonnummer: " + userPhone;
            openModal('4'); // Show the modal with booking details
            closeModal('3');
            setTimeout(() => {
                closeModal('4'); // Hide the confirmation modal after some time
            }, 10000); // Adjust timing as needed
        }

    //}, 500); // Adjust the timeout as needed to ensure it works with your AJAX setup
});

function resetForm() {
    document.getElementById('userName').value = '';
    document.getElementById('userPhone').value = '';
}

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

