import { FC } from 'react'
import Conexiones from '../../assets/Conexiones2.png'

const Section3: FC = () => {
    return (
        <div className="parallax-container valign-wrapper">
            <div className="section no-pad-bot">
                <div className="container">
                    <div className="row center">
                        <h5 className="header col s12 light">A modern responsive front-end framework based on Material Design</h5>
                    </div>
                </div>
            </div>
            <div className="parallax">
                <img src={Conexiones} alt="Unsplashed background img 2" />
                </div>
        </div>
    )
}

export default Section3;