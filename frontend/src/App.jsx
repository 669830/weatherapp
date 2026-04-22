import { useState } from 'react'
import SearchBox from './components/SearchBox'
import WeatherCard from './components/WeatherCard'
import './App.css'

function App() {
  const [weather, setWeather] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  const handleSearch = async (city) => {
    setLoading(true)
    setError('')
    setWeather(null)

    try {
      const res = await fetch(`/api/weather?city=${encodeURIComponent(city)}`)
      const data = await res.json()

      if (!res.ok) {
        setError(data.error || 'Something went wrong')
        return
      }

      setWeather(data)
    } catch {
      setError('Failed to connect to the server. Is the backend running?')
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="container">
      <h1>Weather App</h1>
      <SearchBox onSearch={handleSearch} loading={loading} />
      {error && <div className="error">{error}</div>}
      {weather && <WeatherCard data={weather} />}
    </div>
  )
}

export default App
