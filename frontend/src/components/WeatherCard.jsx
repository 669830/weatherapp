export default function WeatherCard({ data }) {
  return (
    <div className="weather-card">
      <div className="city-name">{data.city}</div>
      <div className="country">{data.country}</div>
      <div className="weather-icon">
        <img
          src={`https://openweathermap.org/img/wn/${data.icon}@2x.png`}
          alt={data.description}
        />
      </div>
      <div className="temp">{Math.round(data.temp)}°C</div>
      <div className="description">{data.description}</div>
      <div className="details">
        <div className="detail">
          <span className="label">Feels like</span>
          <span>{Math.round(data.feelsLike)}°C</span>
        </div>
        <div className="detail">
          <span className="label">Humidity</span>
          <span>{data.humidity}%</span>
        </div>
        <div className="detail">
          <span className="label">Wind</span>
          <span>{data.windSpeed} km/h</span>
        </div>
        <div className="detail">
          <span className="label">Pressure</span>
          <span>{data.pressure} hPa</span>
        </div>
      </div>
    </div>
  )
}
