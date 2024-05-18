import {FC} from "react";
import SectionWins from "../../components/layout/SectionWins";
import HeadWins from "../../components/layout/HeadWins";
import SectionWins2 from "../../components/layout/SectionWins2";


const Wins: FC = () => {
    return (
        <>
            <body >
                <HeadWins />
                <SectionWins />
                <SectionWins2 />
            </body>
        </>
    )
}

export default Wins