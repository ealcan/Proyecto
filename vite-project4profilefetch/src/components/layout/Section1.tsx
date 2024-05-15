import { FC } from 'react'
import '../../App.css'
import CabeceraTierra from '../../assets/Cabecera-Tierra.jpeg'
import LogoNaranja from '../../assets/Logo_ASNT-sin Fondo.png'
import ButtonSubs from '../common/ButtonSubs'


const Section1: FC = () => {
    return (
        <>
            <div id="index-banner" className="parallax-container">
                <div className="section no-pad-bot">
                    <div className="container">
                        <br /><br />
                        <div className="header center">
                            <h3 className="header col s12 light deep-orange-text text-lighten-2 letraGrosor">Your Real Network </h3>
                        </div>
                        <div className="header center">
                        <img src={LogoNaranja} alt="Logo" className="imagen-logo-AWSNT"/>
                        {/* <h1 className="header center deep-orange-text text-lighten-2">AWSNT</h1> */}
                        </div>
                        {/* <div className="row center">
                            <ButtonSubs />
                        </div> */}
                        <br /><br />
                    </div>
                </div>
                <div className="parallax">
                    <img src={CabeceraTierra} className='image-class-opacity' alt="Unsplashed background CabeceraTierra" />
                </div>
            </div>
        </>
    )
}

export default Section1;