document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('errorMessage');

    loginForm.addEventListener('submit', async function(event) {
        event.preventDefault(); // Prevent the default form submission

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        errorMessage.textContent = ''; // Clear previous errors

        try {
            const response = await fetch('/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });

            if (!response.ok) {
                throw new Error('Invalid username or password');
            }

            const data = await response.json();
            
            // Store the token and redirect
            localStorage.setItem('jwt', data.jwt);
            window.location.href = '/admin/dashboard.html'; // Redirect to a protected page

        } catch (error) {
            errorMessage.textContent = error.message;
        }
    });
});