import React from 'react'

export default function App() {
  return (
    <div style={{fontFamily: 'Arial, sans-serif', padding: 20}}>
      <h1>Stock Demo - React</h1>
      <p>Bu React uygulaması backend tarafından sağlanan verileri kullanır.</p>
      <ul>
        <li><a href="/products">Ürünleri Gör (server rendered / REST)</a></li>
        <li><a href="/stocks">Stokları Gör (server rendered / REST)</a></li>
      </ul>
    </div>
  )
}
