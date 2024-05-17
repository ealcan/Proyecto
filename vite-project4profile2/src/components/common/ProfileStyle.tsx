import { useState } from 'react';
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
  MDBBtn,
  MDBBreadcrumb,
  MDBBreadcrumbItem,
  MDBIcon,
  MDBListGroup,
  MDBListGroupItem,
  MDBModal,
  MDBModalBody,
  MDBModalHeader,
} from 'mdb-react-ui-kit';
import { Link } from 'react-router-dom';
import PuestaSol from '../../assets/PuestaSol.jpg'
import Nav from '../layout/Nav';


export default function ProfilePage() {
  const [postDetail, setPostDetail] = useState<{ title: string; message: string } | null>(null);
  const [likes, setLikes] = useState<number>(0);
  const [modalOpen, setModalOpen] = useState<boolean>(false);

  const handleFollowClick = () => {
    setLikes((prevLikes) => prevLikes + 1);
  };

  const toggleModal = () => {
    setModalOpen(!modalOpen);
  };

  return (
    
    <section style={{ backgroundImage: `url(${PuestaSol})` }}>
      <Nav />
      <MDBContainer className="py-5">
        <MDBRow>
          <MDBCol>
            <MDBBreadcrumb className="blue-grey lighten-4">
              <MDBBreadcrumbItem>
                <Link to="/">Home</Link>
              </MDBBreadcrumbItem>
              <MDBBreadcrumbItem>
                <Link to="/ranking">Ranking</Link>
              </MDBBreadcrumbItem>
              <MDBBreadcrumbItem active>User Profile</MDBBreadcrumbItem>
            </MDBBreadcrumb>
          </MDBCol>
        </MDBRow>

        <MDBRow>
          <MDBCol lg="4">
            <MDBCard className="mb-4" style={{ backgroundColor: '#cfd8dc ' }}>
              <MDBCardBody className="text-center">
                <MDBCardImage
                  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                  alt="avatar"
                  className="rounded-circle"
                  style={{ width: '150px' }}
                  fluid
                />
                <p className="text-muted mb-1">Full Stack Developer</p>
                <p className="text-muted mb-4">Bay Area, San Francisco, CA</p>
                <div className="d-flex justify-content-center mb-2">
                  <MDBBtn onClick={handleFollowClick}>Follow</MDBBtn>
                  <MDBBtn outline className="ms-1" onClick={toggleModal}>
                    Message
                  </MDBBtn>
                </div>
                <div className="text-muted">
                  <MDBIcon fas icon="thumbs-up" className="me-1" />
                  <span className="like-count">{likes}</span>
                </div>
              </MDBCardBody>
            </MDBCard>

            <MDBCard className="mb-4 mb-lg-0" style={{ backgroundColor: '#cfd8dc ' }}>
              <MDBCardBody className="p-0">
                <MDBListGroup flush className="rounded-3">
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3 blue-grey lighten-4">
                    <MDBIcon fas icon="globe fa-lg text-warning" />
                    <MDBCardText>https://mdbootstrap.com</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3 blue-grey lighten-4">
                    <MDBIcon fab icon="github fa-lg" style={{ color: '#333333' }} />
                    <MDBCardText>mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3 blue-grey lighten-4">
                    <MDBIcon fab icon="twitter fa-lg" style={{ color: '#55acee' }} />
                    <MDBCardText>@mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3 blue-grey lighten-4">
                    <MDBIcon fab icon="instagram fa-lg" style={{ color: '#ac2bac' }} />
                    <MDBCardText>mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3 blue-grey lighten-4">
                    <MDBIcon fab icon="facebook fa-lg" style={{ color: '#3b5998' }} />
                    <MDBCardText>mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                </MDBListGroup>
              </MDBCardBody>
            </MDBCard>
          </MDBCol>
          <MDBCol lg="8">
            <MDBCard className="mb-4" style={{ backgroundColor: '#cfd8dc' }}>
              <MDBCardBody>
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Full Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">Johnatan Smith</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Email</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">example@example.com</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Phone</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(097) 234-5678</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Mobile</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(098) 765-4321</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Address</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">Bay Area, San Francisco, CA</MDBCardText>
                  </MDBCol>
                </MDBRow>
              </MDBCardBody>
            </MDBCard>

            <MDBRow>
              <MDBCol md="6">
                <MDBCard className="mb-4" style={{ backgroundColor: '#cfd8dc ' }}>
                  <MDBCardBody>
                    <MDBCardText>Additional Info 1</MDBCardText>
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>
              <MDBCol md="6">
                <MDBCard className="mb-4" style={{ backgroundColor: '#cfd8dc ' }}>
                  <MDBCardBody>
                    <MDBCardText>Additional Info 2</MDBCardText>
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>
              </MDBRow>

<MDBCard className="mb-4" style={{ backgroundColor: '#cfd8dc ' }}>

<MDBCardBody className="text-center">
    <MDBCardText className="mb-4" style={{ fontSize: '1.5rem', fontWeight: 'bold' }}>
      Bienvenido a tu perfil
    </MDBCardText>
    <MDBCardText className="text-muted">
      Aquí puedes ver y editar tu información personal, así como crear nuevas publicaciones.
    </MDBCardText>
  </MDBCardBody>
</MDBCard>
</MDBCol>
</MDBRow>
</MDBContainer>

<MDBModal show={modalOpen} onHide={toggleModal}>
<MDBModalHeader toggle={toggleModal}>Enviar mensaje</MDBModalHeader>
<MDBModalBody>
<form>
<div className="mb-3">
  <label htmlFor="messageText" className="form-label">
    Mensaje
  </label>
  <textarea className="form-control" id="messageText" rows={3}></textarea>
</div>
<button type="submit" className="btn btn-primary">
  Enviar
</button>
</form>
</MDBModalBody>
</MDBModal>
</section>
);
}