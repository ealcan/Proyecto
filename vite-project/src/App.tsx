
//IMPORTS
import {Routes, Route} from 'react-router-dom';
import HomeView from "./views/Home/HomeView";
import Footer from './components/layout/Footer';

function App() {
  //CONSTANTES, FUNCIONES, VARIABLES, ETC

  return (
    //IMPRESION HTML
    <>
    <header>

    </header>
      <main>
        <Routes>
          <Route path="/" element={<HomeView />} />
          {/* <Route path="/about" element={<About />} /> */}
        </Routes>
      </main>
        <Footer />
    </>
  )
}
export default App
