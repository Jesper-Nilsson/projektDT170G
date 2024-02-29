document.addEventListener("DOMContentLoaded", function() {
    // Get all elements with the class "test"
    const buttons = document.querySelectorAll('.guestAmountBtn');

    // Loop through each button
    buttons.forEach(function(button) {
        // Add event listener for click event
        button.addEventListener('click', function() {
            closeModal(1);
            openModal(2);
        });
    });
});

// Function to open a modal
function openModal(modalId) {
    document.getElementById("modalStep" + modalId).style.display = 'block';
    document.getElementById("modalStep" + modalId).setAttribute('aria-hidden', 'false');
}

// Function to close a modal
function closeModal(modalId) {
    document.getElementById("modalStep" + modalId).style.display = 'none';
    document.getElementById("modalStep" + modalId).setAttribute('aria-hidden', 'true');
}


// Event listener for booking button
document.getElementById('bookingButton').addEventListener('click', function() {
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

function validateNamePhoneInputs() {
    const nameInput = document.getElementById("j_idt17:userName");
    const phoneInput = document.getElementById("j_idt17:userPhone");

    // Check if the inputs are empty
    const nameIsEmpty = nameInput.value.trim() === '';
    const phoneIsEmpty = phoneInput.value.trim() === '';

    // If both name and phone are required fields
    if (nameIsEmpty || phoneIsEmpty) {
        return false; // Return false if either name or phone is empty
    } else {
        return true; // Return true if both name and phone are provided
    }
}

// Event listener for choosing number of guests
document.getElementById('chooseDate').addEventListener('click', function() {
    if (validateDateTimeInputs()) {
        closeModal('2');
        openModal('3');
    }
});

document.getElementById('j_idt17:saveBooking').addEventListener('click', function(event) {
    // Prevent the default form submission behavior
    event.preventDefault();

    // Perform validation
    if (validateNamePhoneInputs()) {
        closeModal('3');
        alert("Your booking has been saved!");

        // Call the bookingBean.submit() method
        document.getElementById('j_idt17:saveBooking').form.submit();
    } else {
        // Print error (input fields not filled)
    }
});


/*
// Close modals when clicking outside
window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
        closeModal(1);
        closeModal(2);
        closeModal(3);
    }
}*/

// Function to navigate back to the previous modal
function goBackModal(currentModalId, previousModalId) {
    closeModal(currentModalId);
    openModal(previousModalId);
}

function showMoreThanSixInfo() {
    const moreThanSixInfo = document.getElementById("moreThanSixInfo");
    moreThanSixInfo.style.display = "block";
}
