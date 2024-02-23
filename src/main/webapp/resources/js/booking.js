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


function validateInputs() {
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


// Event listener for choosing number of guests
document.getElementById('chooseDate').addEventListener('click', function() {
    if (validateInputs()) {
        closeModal('2');
        openModal('3');
    }
});

// Event listener for saving booking
/*document.getElementById('saveBooking').addEventListener('click', function() {
    // Here you would typically collect all the booking information and send it to the server
    // For the purpose of this example, we'll just log it to the console and close the modal
    var numberOfGuests = document.getElementById('numberOfGuests').value;
    var bookingDate = document.getElementById('bookingDate').value;
    var userName = document.getElementById('userName').value;
    var userPhone = document.getElementById('userPhone').value;

    console.log('Booking details:',
        'Number of Guests:', numberOfGuests,
        'Date:', bookingDate,
        'Name:', userName,
        'Phone:', userPhone);

    // After collecting data, you could send it to the server with an AJAX request or similar.

    // Close the final modal
    closeModal('modalStep3');

    // Optionally, reset the form or provide a confirmation message
    // Reset form example:
    document.getElementById('numberOfGuests').selectedIndex = 0;
    document.getElementById('bookingDate').value = '';
    document.getElementById('userName').value = '';
    document.getElementById('userPhone').value = '';

    // Confirmation message example:
    alert('Din bokning har sparats. Tack!');
});*/



// Close modals when clicking outside
window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
        closeModal(1);
        closeModal(2);
        closeModal(3);
    }
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
