import { FC } from 'react'
import Reto from '../../assets/Reto.png'
import Recompensa from '../../assets/Recompensa.png'
import Publicacion from '../../assets/Publicacion.png'

const Section2: FC = () => {
    return (
        <div className="container">
            <div className="section">

                {/* Icon Section */}
                <div className="row">
                    <div className="col s12 m4">
                        <div className="icon-block">
                            <h2 className="center brown-text">
                                <img src={Reto} className="logo-AWSNT-cabecera"/>
                                </h2>
                            <h5 className="center deep-orange-text text-lighten-1">¿Qué reto te apetece esta semana?</h5>

                            <p className="light div-class">Ayudar a reforestar un bosque, limpiar nuestras playas, ayudar en protectoras, apoyar y promover la agricultura local y sostenible, etc. Escoge un reto, programa una cita, ayuda al planeta y ¡Llévate tu recompensa! ¿Te unes? 😁</p>
                        </div>
                    </div>

                    <div className="col s12 m4">
                        <div className="icon-block">
                            <h2 className="center brown-text">
                            <img src={Recompensa} className="logo-AWSNT-cabecera"/>
                            </h2>
                            <h5 className="center deep-orange-text text-lighten-1">¡Elige tu recompensa!</h5>

                            <p className="light div-class">¡Sumérgete en un mundo de premios y diversión! Consigue entradas gratuitas para el cine, el teatro o la ópera, organiza emocionantes escapadas a destinos increíbles, accede a suscripciones gratuitas a servicios de streaming, y obtén descuentos en restaurantes locales y cafeterías populares, entre otros. ¡Cumple diferentes retos, acumula puntos y canjéalos por el premio que más te guste! Sin duda, ¡hemos llegado a la mejor parte! ¿No crees? 🎁</p>
                        </div>
                    </div>

                    <div className="col s12 m4">
                        <div className="icon-block">
                            <h2 className="center brown-text">
                            <img src={Publicacion} className="logo-AWSNT-cabecera"/>
                            </h2>
                            <h5 className="center deep-orange-text text-lighten-1">Publica y comparte tus experiencias</h5>

                            <p className="light div-class">¡Captura el momento! Tómate una foto, grábalo en vídeo o crea un pequeño gif. Presume de tus logros ante tus amigos, compite con ellos e intenta alcanzar el primer puesto en el ranking. ¡Todo suma puntos!🌟</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default Section2;