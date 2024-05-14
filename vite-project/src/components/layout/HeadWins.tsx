
import { FC } from 'react'
import '../../App.css'
import ImgReward from '../../assets/bosque3.jpg'

const Section4: FC = () => {
    return (
        <>
            <div id="index-banner" className="parallax-container">
                <div className="section no-pad-bot">
                    <div className="container">
                        <br /><br />
                        <div className="header center">
                            <h2 className="header center col s12 white-text  letraRewards">Objetivos</h2>
                            <h3 className="header center col s12 white-text  letraRewards">
                               ¡Tus esfuerzos tienen un impacto en el mundo!
                            </h3>
                            <h4 className="header center col s12 white-text  letraRewards">
                               Realiza los siguientes objetivos y obtén puntos como recompensa
                            </h4>
                        </div>
                        <div className="header center">
                        </div>
                        <br /><br />
                    </div>
                </div>
                <div className="parallax">
                    <img src={ImgReward} className='image-class-opacity' alt="Unsplashed background CabeceraTierra" style={{opacity: "0.8"}}/>
                </div>
            </div>
        </>
    )
}

export default Section4;