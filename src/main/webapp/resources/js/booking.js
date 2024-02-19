const warningEmptyGuest = document.getElementById("warningChooseGuests");
// Modify the chooseGuests button event listener
document.getElementById('chooseGuests').addEventListener('click', function() {
    const activeGuest = document.querySelector('.guest-list li.active');
    // Check if a guest number has been selected
    if (!activeGuest) {
        // No guest selected, show warning
        warningEmptyGuest.style.display = 'block';
    } else {
        // Proceed as normal if a guest is selected
        closeModal('modalStep1');
        openModal('modalStep2');
    }
});
// Function to open a modal
function openModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
    document.getElementById(modalId).setAttribute('aria-hidden', 'false');
}

// Function to close a modal
function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
    document.getElementById(modalId).setAttribute('aria-hidden', 'true');
}


// Event listener for booking button
document.getElementById('bookingButton').addEventListener('click', function() {
    openModal('modalStep1');
});


// Event listener for choosing number of guests
document.getElementById('chooseGuests').addEventListener('click', function() {
    closeModal('modalStep1');
    openModal('modalStep2');
});

// Event listener for choosing number of guests
document.getElementById('chooseDate').addEventListener('click', function() {
    closeModal('modalStep2');
    openModal('modalStep3');
});

// Event listener for saving booking
document.getElementById('saveBooking').addEventListener('click', function() {
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
});

// You might also want to add event listeners for the close buttons
// Here's an example for one, repeat for others
document.querySelectorAll('.close').forEach(function(element) {
    element.addEventListener('click', function() {
        var modalId = this.closest('.modal').getAttribute('id');
        closeModal(modalId);
    });
});

// To enhance UX, consider closing modals on outside click
window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
        closeModal(event.target.getAttribute('id'));
    }
}

// Additional enhancements might be needed for accessibility, like trapping focus within the modal


// Function to navigate back to the previous modal
function goBack(currentModalId, previousModalId) {
    closeModal(currentModalId);
    openModal(previousModalId);
}

// Update closeModal function to reset aria-hidden attribute
function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = 'none';
    modal.setAttribute('aria-hidden', 'true');
}

// Update openModal function to set aria-hidden attribute
function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = 'block';
    modal.setAttribute('aria-hidden', 'false');
}

// Ol List guest js examples
// JavaScript to handle guest selection from the list
document.querySelectorAll('.guest-list li').forEach(item => {
    item.addEventListener('click', function() {
        warningEmptyGuest.style.display = 'none';

        // Remove active class from all items
        document.querySelectorAll('.guest-list li').forEach(li => {
            li.classList.remove('active');
        });


        // Add active class to clicked item
        this.classList.add('active');

        // Store the selected number of guests for later use
        var numberOfGuests = this.getAttribute('value');
        console.log('Selected number of guests:', numberOfGuests);

        // You may want to store the selected number of guests in a variable or directly use it
        // for further actions, such as proceeding to the next step in your booking process.
    });
});

// Add a CSS rule for .active to highlight the selected item