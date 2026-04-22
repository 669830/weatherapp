# Værapp

En fullstack værapplikasjon som henter sanntidsværdata via OpenWeatherMap API.

## Teknologier

| Del | Teknologi |
|-----|-----------|
| Frontend | React 18 + Vite |
| Backend | Spring Boot 3 (Java 17+) |
| API | OpenWeatherMap |

## Struktur

```
weatherapp/
├── backend/          # Spring Boot REST API
│   └── src/main/java/com/weather/
│       ├── controller/   # HTTP-endepunkter
│       ├── service/      # Kall mot OpenWeatherMap
│       └── model/        # WeatherData (record)
└── frontend/         # React-applikasjon
    └── src/
        ├── components/   # SearchBox, WeatherCard
        └── App.jsx
```

## Kom i gang

### Krav
- Java 17 eller nyere
- Node.js 18 eller nyere

### 1. Sett opp API-nøkkel

Opprett en gratis konto på [openweathermap.org](https://openweathermap.org/api) og kopier API-nøkkelen din.

Kopier eksempelfilen og lim inn nøkkelen:

```bash
cp backend/src/main/resources/application.properties.example \
   backend/src/main/resources/application.properties
```

Åpne `application.properties` og erstatt `YOUR_API_KEY_HERE` med din nøkkel.

### 2. Start backend

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Serveren starter på `http://localhost:8080`.

### 3. Start frontend

```powershell
cd frontend
npm install
npm run dev
```

Åpne `http://localhost:5173` i nettleseren.

## API

Backend eksponerer ett endepunkt:

```
GET /api/weather?city={bynavn}
```

**Eksempel respons:**
```json
{
  "city": "Oslo",
  "country": "NO",
  "temp": 8.3,
  "feelsLike": 5.1,
  "description": "light rain",
  "icon": "10d",
  "humidity": 81,
  "windSpeed": 14.4,
  "pressure": 1008
}
```

## Funksjonalitet

- Søk på hvilken som helst by i verden
- Viser temperatur, føles-som, fuktighet, vind og lufttrykk
- Værikoner fra OpenWeatherMap
- Feilmelding ved ugyldig by eller nettverksproblemer
- API-nøkkelen ligger trygt på backend — eksponeres aldri til nettleseren
