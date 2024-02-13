// Function to open the popup
    function openPopup() {
    document.getElementById('popupEvent').style.display = 'block';
}

    // Function to close the popup
    function closePopup() {
    document.getElementById('popupEvent').style.display = 'none';
}

    // Stop propagation to prevent clicks within the popup from closing it
    document.getElementById('popupEvent').onclick = function(event) {
    event.stopPropagation();
};

    // Close the popup when clicking anywhere on the window
    window.onclick = function() {
    closePopup();
};

    // Delay the popup to open 2 seconds after the DOM is loaded
    document.addEventListener('DOMContentLoaded', (event) => {
    setTimeout(openPopup, 1000);
});

