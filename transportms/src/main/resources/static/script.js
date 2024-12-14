// Toggle the Login Form (Modal)
function toggleLoginForm() {
    const loginForm = document.getElementById('loginForm');
    // Toggle between showing and hiding the form
    loginForm.style.display = loginForm.style.display === 'flex' ? 'none' : 'flex';
}

// Handle Login Logic
function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;


    if (!username || !password) {
        alert("Please enter both username and password!");
    } else {
        // Simulate a successful login process
        alert(`Welcome, ${username}!`);
        toggleLoginForm(); // Close the login modal
    }
}

// Back to Top Button
const backToTopButton = document.getElementById('backToTop');
if (backToTopButton) {
    window.addEventListener('scroll', () => {
        if (window.scrollY > 300) {
            backToTopButton.style.display = 'block';
        } else {
            backToTopButton.style.display = 'none';
        }
    });

    backToTopButton.addEventListener('click', () => {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    });
}

// Search Functionality (Optional Enhancement)
const searchBar = document.getElementById('searchBar');
if (searchBar) {
    searchBar.addEventListener('keypress', (event) => {
        if (event.key === 'Enter') {
            const query = searchBar.value.trim();
            if (query) {
                alert(`Searching for: ${query}`);
                // Implement search functionality if needed
            }
        }
    });
}

// Smooth scroll to Routes section
const routesLink = document.querySelector('.sidebar a[href="#routesSection"]');
if (routesLink) {
    routesLink.addEventListener('click', (e) => {
        e.preventDefault();
        const routesSection = document.querySelector('#routesSection');
        routesSection.scrollIntoView({ behavior: 'smooth' });
    });
}


// Sidebar Navigation Highlight
const navLinks = document.querySelectorAll('.sidebar a');
navLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        navLinks.forEach(nav => nav.classList.remove('active'));
        e.target.classList.add('active');
    });
});

// Tooltip on Sidebar Links (Optional)
const sidebarLinks = document.querySelectorAll('.sidebar a');
sidebarLinks.forEach(link => {
    link.addEventListener('mouseover', () => {
        link.setAttribute('title', link.textContent.trim());
    });
});

document.querySelector('.contact-form').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent actual submission
    const name = document.getElementById('contactName').value.trim();
    const email = document.getElementById('contactEmail').value.trim();
    const message = document.getElementById('contactMessage').value.trim();

    if (!name || !email || !message) {
        alert('Please fill out all fields!');
    } else {
        alert(`Thank you, ${name}! Your message has been sent.`);
        document.querySelector('.contact-form').reset(); // Clear form
    }
});


// Toggle the Ticket Form (Modal)
function toggleTicketForm() {
    const ticketForm = document.getElementById('ticketForm');
    ticketForm.style.display = ticketForm.style.display === 'flex' ? 'none' : 'flex';
}

// Handle Ticket Submission
function submitTicket() {
    const studentId = document.getElementById('studentId').value;
    const studentName = document.getElementById('studentName').value;
    const fromLocation = document.getElementById('fromLocation').value;
    const toLocation = document.getElementById('toLocation').value;
    const sitNumber = document.getElementById('sitNumber').value;

    if (!studentId || !studentName || !fromLocation || !toLocation ) {
        alert("Please fill out all fields!");
        return;
    }

    // Simulate submission (could connect to backend later)
    alert(`Ticket booked successfully for ${studentName} (${studentId}) from ${fromLocation} to ${toLocation}.`);
    toggleTicketForm(); // Close the modal
}

// Event Listener for Ticket Button
const ticketButton = document.getElementById('ticketButton');
if (ticketButton) {
    ticketButton.addEventListener('click', toggleTicketForm);
}

const searchInput = document.getElementById('routeSearch');
searchInput.addEventListener('input', () => {
    const query = searchInput.value.toLowerCase();
    document.querySelectorAll('.route-cards .card').forEach(card => {
        const routeName = card.querySelector('h3').textContent.toLowerCase();
        card.style.display = routeName.includes(query) ? 'block' : 'none';
    });
});

