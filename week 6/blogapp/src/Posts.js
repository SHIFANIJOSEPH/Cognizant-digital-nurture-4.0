import React, { Component } from 'react'

export class Posts extends Component {
  constructor(props){
    super(props);
     this.state = {
      posts: []
    };
  }
   loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
      });
  }

  componentDidMount() {
    
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => this.setState({ posts: data }))
      .catch(error => console.error('Error fetching posts:', error));
  }
  componentDidCatch(error, info) {
    
    this.setState({ hasError: true });
    alert('An error occurred while displaying the posts.');
    console.error("Error:", error);
    console.error("Error Info:", info);
  }
  render() {
    return (
      <div>
        <h2>All Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}



export default Posts