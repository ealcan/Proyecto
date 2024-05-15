
// main.tsx, si no me equivoco va ser el archivo de TYPESCRIPT
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import App from './App';

// Importa los estilos de Materialize
import 'materialize-css/dist/css/materialize.min.css';
// Importa Materialize para su inicialización
import M from 'materialize-css'; 

// Inicializa los componentes de Materialize después de que el DOM haya cargado
document.addEventListener('DOMContentLoaded', function() {
  M.AutoInit();
});

// ReactDOM.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>,
//   document.getElementById('root')
// );

ReactDOM.render(
  <Router>
    <App />
  </Router>,
  document.getElementById('root')
);


