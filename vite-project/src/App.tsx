
//IMPORTS
import {Routes, Route} from 'react-router-dom';
import HomeView from "./views/Home/HomeView";
import Footer from './components/layout/Footer';
import Rewards from './views/Rewards/rewards';
import Wins from './views/Wins/Wins';
import { QueryClient, QueryClientProvider } from "react-query";

const queryClient = new QueryClient();
function App() {
  //CONSTANTES, FUNCIONES, VARIABLES, ETC

  return (
    //IMPRESION HTML
    <QueryClientProvider client={queryClient}>
    <>
    <header>

    </header>
      <main>
        <Routes>
          <Route path="/" element={<HomeView />} />
          <Route path="/rewards" element={<Rewards />} />
          <Route path="/wins" element={<Wins />} />
          {/* <Route path="/about" element={<About />} /> */}
        </Routes>
      </main>
        <Footer />
    </>
    </QueryClientProvider>
  )
}
export default App
