//Imports de componente';
import { FC } from 'react'
import Nav from '../../components/layout/Nav';
import Body from '../../components/layout/Body';

const HomeView: FC = () => {
    return (
        <>
            <header>
                <Nav />
            </header>
            <body>
                <Body />
            </body>
        </>
    )
}

export default HomeView