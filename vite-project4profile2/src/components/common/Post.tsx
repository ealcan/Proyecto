import React, { useState } from 'react';
import { MDBBtn, MDBCol, MDBRow, MDBCard, MDBCardBody } from 'mdb-react-ui-kit';

interface PostFormProps {
  onSubmit: (postDetail: { title: string, message: string }) => void;
}

const PostForm: React.FC<PostFormProps> = ({ onSubmit }) => {
  const [title, setTitle] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onSubmit({ title, message });
    setTitle('');
    setMessage('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <MDBRow>
        <MDBCol md="12" className="mb-3">
          <label htmlFor="title" className="form-label">Title</label>
          <input
            type="text"
            id="title"
            className="form-control"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </MDBCol>
        <MDBCol md="12" className="mb-3">
          <label htmlFor="message" className="form-label">Message</label>
          <textarea
            id="message"
            className="form-control"
            rows={4}
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            required
          ></textarea>
        </MDBCol>
        <MDBCol md="12" className="mb-3">
          <MDBBtn type="submit">Submit</MDBBtn>
        </MDBCol>
      </MDBRow>
    </form>
  );
};

export default PostForm;



