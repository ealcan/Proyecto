
import { FC } from 'react'
import '../../App.css'
import ImgReward from '../../assets/Playa.jpg'
import "../../styles/RewardsStyle.css"

const Section4: FC = () => {
    return (
        <>
            <div id="index-banner" className="parallax-container">
                <div className="section no-pad-bot">
                    <div className="container">
                        <br /><br />
                        <div className="header center">
                            <h2 className="header center col s12 white-text  letraRewards">Recompensas</h2>
                            <h3 className="header center col s12 white-text  letraRewards">
                               ¡Cada pequeño paso cuenta!
                            </h3>
                            <h4 className="header center col s12 white-text  letraRewards ">
                              Completa tus objetivos, acumula puntos y canjéalos por premios increíbles.
                            </h4>
                        </div>
                        <div className="header center">
                        </div>
                        <br /><br />
                    </div>
                </div>
                <div className="parallax">
                    <img src={ImgReward} className='image-class-opacity' alt="Unsplashed background CabeceraTierra" />
                </div>
            </div>
        </>
    )
}

export default Section4;