import {FC} from "react";
import SectionRewards from '../../components/layout/SectionRewards';
import HeadRewards from '../../components/layout/HeadRewards';
  

  
const rewards: FC = () => {

    return (

      <>
        <body >
          <HeadRewards />
          <SectionRewards />
        </body>
    </>
  )
}

export default rewards