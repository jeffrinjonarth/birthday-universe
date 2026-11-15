# BIRTHDAY UNIVERSE

A configurable cinematic birthday website built with Java 17, Spring Boot, Thymeleaf, Spring Data JPA, H2, HTML, CSS and JavaScript.

## Requirements
- Java 17+
- Maven 3.8+
- Internet connection for Google Fonts and the GSAP CDN (the site itself and core animations work without GSAP).

## Run
From this folder:

```bash
mvn clean install
mvn spring-boot:run
```

Open http://localhost:8080

## Personalize
Edit `src/main/resources/application.properties`:

```properties
birthday.name=BG Selvin Raj
birthday.date=2026-11-16
birthday.age=21
birthday.message=Your personal birthday message goes here.
```

Restart the app after changing properties. The age is optional; the date is configurable for your own future countdown enhancement.

## Add your own photos
Put image files in `src/main/resources/static/images/`. Update the three `<article class="photo-card">` image URLs in `templates/index.html` to `/images/your-photo.jpg`. Replace the sample timeline entries in `MemoryService.java` with your own dates, captions and image paths.

## API
- `GET /api/wishes` — list wishes
- `POST /api/wishes` — create a wish. JSON example: `{"name":"Alex","message":"Have a wonderful year!","emoji":"🎉"}`
- `GET /api/memories` — sample timeline data
- `GET /api/gallery` — sample gallery data

H2 persists to `./data/birthdaydb`. Optional database console: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:file:./data/birthdaydb`, username `sa`, blank password).

## Notes
- The intro can be skipped with its button and automatically continues after 12 seconds.
- Audio starts only after the visitor clicks the music control.
- The wish wall is backed by H2 and validates basic input constraints.
- The visual gallery currently uses sample remote photographs; replace them with images you have permission to use.
- The project targets smooth, lightweight effects and respects `prefers-reduced-motion`; actual frame rate depends on the device and browser.
