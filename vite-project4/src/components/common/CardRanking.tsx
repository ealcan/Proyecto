import React, { useState, useEffect } from 'react';
import cartaimg from '../../assets/cartaimg.jpg';

interface Profile {
    name: string;
    lastName: string;
    image: string;
    points: number;
    username: string;
    wins: [];
    rewards: [];
    posts: [];
    rankingPoints: number;


}

const CardRanking: React.FC = () => {
    const [personas, setPersonas] = useState<Profile[]>([]);

    useEffect(() => {
        const fetchUsuarios = async () => {
            try {
                // Realizar la solicitud HTTP para obtener los datos de la API
                const response = await fetch('localhost:8080/profiles/global-ranking');
                const data = await response.json();

                // Mapear los datos de la API a la estructura de Persona
                const personasData: Profile[] = data.map((usuarioData: any, index: number) => ({
                    name: usuarioData.name, // Suponiendo que la API devuelve el nombre del usuario
                    lastname: usuarioData.lastname,
                    image: cartaimg, // Generar una imagen aleatoria para cada personagen: cartaimg, // Utilizamos la misma imagen para todas las personas
                    opacity: 0.1 + index * 0.1,
                }));

                // Actualizar el estado personas con los datos obtenidos de la API
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
                <div key={index} className="card" style={{ width: '250px', height: 'auto', marginBottom: '20px', marginLeft: '20px', opacity: persona.opacity ?? 0.1, transition: `opacity 1.0s ease-in-out ${index * 0.5}s`, boxShadow: '0 2px 8px rgba(0,0,0,0.1)', borderRadius: '8px' }}>
                    <div style={{ padding: '10px', backgroundColor: '#80deea', borderRadius: '8px 8px 0 0', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
                        <h2 style={{ margin: '0', textAlign: 'center', fontSize: '1.5em' }}>{`Ranking #${index + 1}`}</h2>
                    </div>
                    <div style={{ textAlign: 'center', padding: '20px 0', backgroundColor: '#ffffff', borderRadius: '0 0 8px 8px' }}>
                        <img
                            src={persona.image}
                            alt="Imagen de la persona"
                            style={{
                                width: '100%',
                                height: 'auto',
                                opacity: persona.opacity ?? 1,
                                transition: 'opacity 1.0s ease-in-out',
                                borderRadius: '8px',
                            }}
                        />
                    </div>
                    <div style={{ textAlign: 'center', padding: '10px 0' }}>
                        <h4 style={{ margin: '5px 0', fontSize: '1em' }}>{persona.name}</h4>
                        <h5 style={{ margin: '5px 0', color: '#888', fontSize: '0.9em' }}>{persona.lastname}</h5>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default CardRanking;
