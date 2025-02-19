# ShortThatURL
Simple URL shortner application, 
</n><br>
This repository is test repository to make dummy application and self host on ubuntu VM 
</n></br> 
URL Shortener 🔗
- Backend: API to shorten long URLs and store them
- Frontend: Input field to enter long URLs, display shortened URL
- Database: MySQL / Redis
- Bonus: Track clicks on shortened URLs

High-Level Plan
- 1️⃣ Backend (Spring Boot)
    - API to shorten a URL (store mapping of long URL → short code)
    - API to redirect a short URL to the original URL
    - API to view analytics (click count per short URL)
    - Store URLs in MySQL / PostgreSQL
</br>

- 2️⃣ Frontend (React)
    - Input field for entering long URLs
    - Display generated short URLs
    - List previously shortened URLs
</br>

- 3️⃣ Bonus Features
    - Track click analytics (store timestamp & IP of visitors)
    - Allow custom short URLs (e.g., mysite.com/kushagra)
    - User authentication (optional)
</br>

```
ShortThatURL/
│── backend/                   # Spring Boot Backend
│   ├── src/main/java/com/example/urlshortener/
│   │   ├── UrlShortenerApplication.java   # Main Spring Boot application
│   │   ├── controller/
│   │   │   ├── UrlController.java         # Handles API requests
│   │   ├── service/
│   │   │   ├── UrlService.java            # Business logic
│   │   ├── repository/
│   │   │   ├── UrlRepository.java         # Database interaction
│   │   ├── model/
│   │   │   ├── Url.java                   # Database entity
│   │   ├── utils/
│   │   │   ├── Base62Encoder.java         # Short URL generator (optional)
│   ├── src/main/resources/
│   │   ├── application.properties         # Database config
│   ├── pom.xml                             # Maven Dependencies
│
│── frontend/                  # React Frontend
│   ├── node_modules/           # Dependencies (ignored in Git)
│   ├── public/
│   │   ├── index.html          # Main HTML file
│   ├── src/
│   │   ├── components/         # Reusable React components
│   │   ├── pages/              # Page components
│   │   ├── App.js              # Main App component
│   │   ├── index.js            # ReactDOM entry point
│   ├── package.json            # Frontend dependencies
│   ├── .gitignore              # Ignore unnecessary files
│   ├── README.md               # Frontend documentation
│
│── deployment/                 # Deployment-related files
│   ├── docker-compose.yml       # Docker Compose config (if using)
│   ├── nginx.conf               # Nginx config (if using reverse proxy)
│   ├── deploy.sh                # Deployment script
│
│── .gitignore                   # Ignore unnecessary files globally
│── README.md                     # Project documentation
```
