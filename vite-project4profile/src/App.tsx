
//IMPORTS
import {Routes, Route} from 'react-router-dom';
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import HomeView from "./views/Home/HomeView";
import Footer from './components/layout/Footer';
import Rewards from './views/Rewards/rewards';
import Ranking from './views/Ranking/Ranking';
import Nav from './components/layout/Nav';
import {
	QueryClient,
	QueryClientProvider
} from "react-query";
import Profile from './views/Profile/Profile';

const queryClient = new QueryClient();
function App() {
  //CONSTANTES, FUNCIONES, VARIABLES, ETC

  return (
    //IMPRESION HTML
    <QueryClientProvider client={queryClient}>
    <>
    <header>
      <Nav />
    </header>
      <main>
        <Routes>
          <Route path="/" element={<HomeView />} />
          <Route path="/rewards" element={<Rewards />} />
          <Route path="/ranking" element={<Ranking />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </main>
        <Footer />
    </>
    </QueryClientProvider>
  )
}
export default App
