import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';


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
  MDBProgress,
  MDBProgressBar,
  MDBIcon,
  MDBListGroup,
  MDBListGroupItem
} from 'mdb-react-ui-kit';

export interface Profile {
  name: string
  lastName: string
  username: string
  email: string
  points: number
  profile_image: string
  wins: Win[]
  rewards: Reward[]
  posts: Post[]
  rankingPoints: number
}

export interface Win {
  id: number
  name: string
  description: string
  rewardsPoints: number
  image: any
}

export interface Reward {
  id: number
  description: string
  name: string
  pricePoints: number
  image: any
}

export interface Post {
  id: number
  title: string
  content: string
  profile: Profile
  likes: Like[]
  publishedAt: string
}

export interface Profile {
  id: number
  profileImage: string
  name: string
  lastname: string
}

export interface Like {
  id: number
  profileImage: string
  name: string
  lastname: string
}
const ProfilePage: React.FC = () => {

  const location = useLocation();
  const pathnameParts = location.pathname.split('/');
  const id = pathnameParts[pathnameParts.length - 1];

  const [personas, setPersonas] = useState<Profile[]>([]);

  const [wins, setWins] = useState<Win[]>([]);

  const [rewards, setRewards] = useState<Reward[]>([]);

  const [posts, setPosts] = useState<Post[]>([]);

  const [users, setUsers] = useState<Profile[]>([]);

  useEffect(() => {
      const fetchUsuarios = async () => {
          try {
              const response = await fetch(`http://localhost:8080/profiles/${id}`);
              if (!response.ok) {
                  throw new Error('Failed to fetch data');
              }
              const data = await response.json();

              const personasData: Profile[] = {
                  name: data.name,
                  lastName: data.lastName,
                  profile_image: data.profile_image,
                  points: data.points,
                  username: data.username,
                  email: data.email,
                  wins: data.wins,
                  rewards: data.rewards,
                  posts: data.posts,
                  rankingPoints: data.rankingPoints,
              };
        
              const winsArray: Win[] = data.wins;

              const rewardsArray: Reward[] = data.rewards;

              const postsArray: Post[] = data.posts;



              setPersonas(personasData);
              setWins(winsArray);
              setRewards(rewardsArray);
              setPosts(postsArray);
          } catch (error) {
              console.error('Error al obtener datos de la API:', error);
          }

          try {
            const response = await fetch(`http://localhost:8080/friends/ranking/${id}`);
            if (!response.ok) {
                throw new Error('Failed to fetch data');
            }
            const data1 = await response.json();

            const userData: Profile[] = data1.map((usuarioData: any, index: number) => ({
              name: usuarioData.name,
              lastName: usuarioData.lastName,
              profile_image: usuarioData.profile_image,
              points: usuarioData.points,
              username: usuarioData.username,
              wins: usuarioData.wins,
              rewards: usuarioData.rewards,
              posts: usuarioData.posts,
              rankingPoints: usuarioData.rankingPoints,

          }));
      
          setUsers(userData);

        } catch (error) {
            console.error('Error al obtener datos de la API:', error);
        }
      };

      fetchUsuarios();
  }, [id]);


  return (
    <section style={{ backgroundColor: '#eee' }}>
      <MDBContainer className="py-5">
        <MDBRow>
          <MDBCol>
            <MDBBreadcrumb className="bg-light rounded-3 p-3 mb-4">
              <MDBBreadcrumbItem>
                <a href='#'>Home</a>
              </MDBBreadcrumbItem>
              <MDBBreadcrumbItem>
                <a href="#">User</a>
              </MDBBreadcrumbItem>
              <MDBBreadcrumbItem active>User Profile</MDBBreadcrumbItem>
            </MDBBreadcrumb>
          </MDBCol>
        </MDBRow>

        <MDBRow>
          <MDBCol lg="4">
            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <MDBCardImage
                  src={personas.profile_image}
                  alt="avatar"
                  className="rounded-circle"
                  style={{ width: '150px', height: '150px' }}
                  fluid />
                <p className="text-muted mb-1">@{personas.username}</p>
                <div className="d-flex justify-content-center mb-2">
                  <br />
                  <MDBBtn>Follow</MDBBtn>
                  <MDBBtn outline className="ms-1">Message</MDBBtn>
                </div>
              </MDBCardBody>
            </MDBCard>

            {users.length > 0 ? (
                    <>
            <MDBCard className="mb-4 mb-lg-0">
              <MDBCardBody className="p-0">
                <MDBListGroup flush className="rounded-3">
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                    <MDBIcon fas icon="globe fa-lg text-warning" />
                    <MDBCardText>{users[0].username}</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                    <MDBIcon fab icon="github fa-lg" style={{ color: '#333333' }} />
                    <MDBCardText>{users[1].username}</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                    <MDBIcon fab icon="twitter fa-lg" style={{ color: '#55acee' }} />
                    <MDBCardText>{users[2].username}</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                    <MDBIcon fab icon="instagram fa-lg" style={{ color: '#ac2bac' }} />
                    <MDBCardText>mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                  <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                    <MDBIcon fab icon="facebook fa-lg" style={{ color: '#3b5998' }} />
                    <MDBCardText>mdbootstrap</MDBCardText>
                  </MDBListGroupItem>
                </MDBListGroup>
              </MDBCardBody>
            </MDBCard>
            </>
                ) : (
                  <p>No hay datos de ganancias disponibles.</p>
                )}
          </MDBCol>
          <MDBCol lg="8">
            <MDBCard className="mb-4">
              <MDBCardBody>
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Full Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">{personas.name} {personas.lastName}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Email</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">{personas.email}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Points</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">{personas.points}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Ranking Points</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">{personas.rankingPoints}</MDBCardText>
                  </MDBCol>
                </MDBRow>
              </MDBCardBody>
            </MDBCard>

            <MDBRow>
              <MDBCol md="6">
                <MDBCard className="mb-4 mb-md-0">
                  <MDBCardBody>
                  {wins.length > 0 ? (
                    <>
                    <MDBCardText className="mb-4"><span className="text-primary font-italic me-1">Wins</span> {wins[0].name}</MDBCardText>
                    <MDBCardText className="mb-1" style={{ fontSize: '.77rem' }}>{wins[0].description}</MDBCardText>
                    <MDBProgress className="rounded">
                      <MDBProgressBar width={80} valuemin={0} valuemax={100} />
                    </MDBProgress>
                    <img src={wins[0].image} height="100" width="120"></img>
                    </>
                    ) : (
                      <p>No hay datos de ganancias disponibles.</p>
                    )}
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>

              <MDBCol md="6">
                <MDBCard className="mb-4 mb-md-0">
                  <MDBCardBody>
                  {rewards.length > 0 ? (
                    <>
                    <MDBCardText className="mb-4"><span className="text-primary font-italic me-1">Rewards</span> {rewards[0].name}</MDBCardText>
                    <MDBCardText className="mb-1" style={{ fontSize: '.77rem' }}>{rewards[0].description}</MDBCardText>
                    <MDBProgress className="rounded">
                      <MDBProgressBar width={80} valuemin={0} valuemax={100} />
                    </MDBProgress>
                    <img src={rewards[0].image} height="100" width="120"></img>
                    </>
                    ) : (
                      <p>No hay datos de ganancias disponibles.</p>
                    )}
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>

              <MDBCol md="6">
                <MDBCard className="mb-4 mb-md-0">
                  <MDBCardBody>
                  {posts.length > 0 ? (
                    <>
                    <MDBCardText className="mb-4"><span className="text-primary font-italic me-1">Post</span> {posts[0].title}</MDBCardText>
                    <MDBCardText className="mb-1" style={{ fontSize: '.77rem' }}>{posts[0].content}</MDBCardText>
                    <MDBProgress className="rounded">
                      <MDBProgressBar width={80} valuemin={0} valuemax={100} />
                    </MDBProgress>
                    </>
                    ) : (
                      <p>No hay datos de ganancias disponibles.</p>
                    )}
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>
            </MDBRow>
          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </section>
  );
}

export default ProfilePage;
