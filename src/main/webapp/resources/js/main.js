// Function to initialize event listeners on guest selection
// Function to initialize event listeners on guest selection
function initGuestSelection() {
    const guestListItems = document.querySelectorAll('#numberOfGuests li');
    const moreThanSixInfo = document.getElementById('moreThanSixInfo');

    guestListItems.forEach(item => {
        item.addEventListener('click', () => {
            // Assuming you want to check the text content of the item to decide
            // Convert item's text content to a number and compare
            const guestNumber = parseInt(item.textContent, 10);

            // Toggle the additional information for 7 or more guests
            if (guestNumber >= 7) { // Changed to check if guestNumber is 7 or more
                // If already displayed, hide it, otherwise show it
                moreThanSixInfo.style.display = moreThanSixInfo.style.display === 'block' ? 'none' : 'block';
            } else {
                // Hide the information if any other option is selected
                moreThanSixInfo.style.display = 'none';
            }
        });
    });
}


    window.addEventListener('scroll', function() {
    var scrollPosition = window.scrollY;
    var topLinks = document.querySelectorAll('.top-link');

    // Clear any existing timeouts to prevent multiple triggers
    topLinks.forEach(function(link) {
    clearTimeout(link.dataset.timeoutId);
});

    topLinks.forEach(function(link) {
    if (scrollPosition > window.innerHeight * 0.25) {
    // Set a timeout to add the 'show' class after 1 second (1000 milliseconds)
    var timeoutId = setTimeout(function() {
    link.classList.add('show');
}, 1000); // 1000 milliseconds = 1 second

    // Store timeoutId in the link element for potential clearTimeout
    link.dataset.timeoutId = timeoutId;
} else {
    link.classList.remove('show');
}
});
});


// Call the function when the document is fully loaded
document.addEventListener('DOMContentLoaded', initGuestSelection);


