import Nav from '../../components/layout/Nav';
import Win from '../../components/layout/Wins';

function Wins() {
    return (
        <>
            <header>
                <Nav />
            </header>
            <body>
                <br /><br />
                <h3 className="header col s12 light deep-orange-text text-lighten-2 letraGrosor center">Objetivos</h3>
                <br /><br />
                <Win />
                <Win />
            </body>
        </>
    )
}

export default Wins