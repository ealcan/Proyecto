import React, { useState, useEffect } from 'react';
import cartaimg from '../../assets/cartaimg.jpg';

// Definición de los tipos inline para Win, Reward y Post
interface Win {
    id: number;
    name: string;
    description: string;
    rewardsPoints: number;
}

interface Reward {
    id: number;
    name: string;
    description: string;
    pricePoints: number;
}

interface Post {
    title: string;
    content: string;
    numLikes: number;
    publishedAt: string;
}

interface Profile {
    name: string;
    lastName: string;
    profile_image: string;
    points: number;
    username: string;
    wins: Win[];
    rewards: Reward[];
    posts: Post[];
    rankingPoints: number;
    opacity?: number; // Propiedad opcional para manejar transiciones de opacidad
}

const CardRanking: React.FC = () => {
    const [personas, setPersonas] = useState<Profile[]>([]);

    useEffect(() => {
        const fetchUsuarios = async () => {
            try {
                const response = await fetch('http://localhost:8080/profiles/global-ranking');
                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }
                const data = await response.json();

                const personasData: Profile[] = data.map((usuarioData: any, index: number) => ({
                    name: usuarioData.name,
                    lastName: usuarioData.lastName,
                    profile_image: usuarioData.profile_image,
                    points: usuarioData.points,
                    username: usuarioData.username,
                    wins: usuarioData.wins,
                    rewards: usuarioData.rewards,
                    posts: usuarioData.posts,
                    rankingPoints: usuarioData.rankingPoints,
                    opacity: 0.1 // Inicialmente establece la opacidad a 0.1 para la transición
                }));

                setPersonas(personasData);
            } catch (error) {
                console.error('Error al obtener datos de la API:', error);
            }
        };

        fetchUsuarios();
    }, []);

    useEffect(() => {
        personas.forEach((_, index) => {
            setTimeout(() => {
                setPersonas((prevPersonas) =>
                    prevPersonas.map((persona, i) => (i === index ? { ...persona, opacity: 1 } : persona))
                );
            }, (index + 1) * 500);
        });
    }, [personas]);

    return (
        <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', alignItems: 'flex-start', marginTop: '20px' }}>
            {personas.map((persona, index) => (
                <div key={index} className="card" style={{
                    width: '250px',
                    height: 'auto',
                    marginBottom: '20px',
                    marginLeft: '20px',
                    opacity: persona.opacity ?? 0.1,
                    transition: `opacity 1.0s ease-in-out ${index * 0.5}s`,
                    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
                    borderRadius: '8px'
                }}>
                    <div style={{ padding: '10px', backgroundColor: '#80deea', borderRadius: '8px 8px 0 0', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
                        <h2 style={{ margin: '0', textAlign: 'center', fontSize: '1.5em' }}>{`Ranking #${index + 1}`}</h2>
                    </div>
                    <div style={{ textAlign: 'center', padding: '20px 0', backgroundColor: '#ffffff', borderRadius: '0 0 8px 8px' }}>
                        <img
                            src={persona.profile_image}
                            alt="Imagen de Usuario"
                            style={{
                                width: '100%',
                                height: 'auto',
                                transition: 'opacity 1.0s ease-in-out',
                                borderRadius: '8px',
                                aspectRatio: '1/1',
                                objectFit: 'cover',
                            }}
                        />
                    </div>
                    <div style={{ textAlign: 'center', padding: '10px 0' }}>
                        <h4 style={{ margin: '5px 0', fontSize: '1em' }}>{persona.name}</h4>
                        <h5 style={{ margin: '5px 0', color: '#888', fontSize: '0.9em' }}>{persona.lastName}</h5>
                        <h5 style={{ margin: '5px 0', color: '#888', fontSize: '0.9em' }}>Points: {persona.rankingPoints}</h5>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default CardRanking;
