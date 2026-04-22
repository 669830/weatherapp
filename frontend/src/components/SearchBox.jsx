import { useState } from 'react'

export default function SearchBox({ onSearch, loading }) {
  const [city, setCity] = useState('')

  const handleSubmit = () => {
    if (city.trim()) onSearch(city.trim())
  }

  return (
    <div className="search-box">
      <input
        type="text"
        value={city}
        onChange={(e) => setCity(e.target.value)}
        onKeyDown={(e) => e.key === 'Enter' && handleSubmit()}
        placeholder="Enter city name..."
        autoComplete="off"
      />
      <button onClick={handleSubmit} disabled={loading}>
        {loading ? '...' : 'Search'}
      </button>
    </div>
  )
}
