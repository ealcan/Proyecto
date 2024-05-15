import { FC } from 'react'

const Footer: FC = () => {
    return (
        <>
            <footer className="page-footer colorbase">
                <div className="container">
                    <div className="row colorbase">
                        <div className="col l6 s12">
                            <h5 className="white-text">Footer Content</h5>
                            <p className="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                        </div>
                        <div className="col l4 offset-l2 s12 colorbase">
                            <h5 className="white-text">Links</h5>
                            <ul>
                                <li><a className="grey-text text-lighten-3" href="#!">Link 1</a></li>
                                <li><a className="grey-text text-lighten-3" href="#!">Link 2</a></li>
                                <li><a className="grey-text text-lighten-3" href="#!">Link 3</a></li>
                                <li><a className="grey-text text-lighten-3" href="#!">Link 4</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div className="footer-copyright">
                    <div className="container rgba(51,51,51,0.08)">
                        © 2024 Copyright
                        <a className="grey-text text-lighten-4 right" href="#!">Awareness Social Network </a>
                    </div>
                </div>
            </footer>
        </>
    )
}

export default Footer