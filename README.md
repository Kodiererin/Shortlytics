# Shortlytics - URL Shortener with Analytics

Shortlytics is a powerful URL shortener built using **Spring Boot** and **MongoDB**. It features efficient URL shortening with caching for faster access and the use of custom algorithms to generate shortened URLs. The project also provides real-time analytics for tracking URL usage.

## Features

- 🗜️ **URL Shortening**: Easily shorten long URLs into short, manageable links.
- ⚡ **Caching**: Implemented caching for faster access and performance optimization.
- 🔒 **Custom Algorithms**: Unique URL shortening algorithms for collision-free shortened links.
- 🏗️ **Built with Spring Boot**: A robust, scalable backend using the Spring ecosystem.
- 💽 **MongoDB Database**: Efficient storage and retrieval of original and shortened URLs using MongoDB.

## Technologies Used

- **Spring Boot**: Backend framework for building the API.
- **MongoDB**: Database used for storing URLs and analytics.
- **Spring Cache**: Used for caching to enhance performance.
- **Spring Data MongoDB**: Provides MongoDB repository functionality.
- **Algorithms**: Custom algorithms implemented for generating unique, collision-free shortened URLs.

## Installation

### Prerequisites

- Java 17 or higher
- MongoDB
- Gradle (for building the project)

### Steps to Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/Shortlytics.git
    cd Shortlytics
    ```

2. **Configure MongoDB**: 
   Update the MongoDB connection settings in the `application.properties` file:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/shortlytics
