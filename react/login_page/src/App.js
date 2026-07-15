import React, {useState} from 'react';
import './App.css';
const App = () => { 
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  var uName = "Siddharth";
  var pWord = "1234";
  function handleLogin() {
    if(username === uName && password === pWord){
      alert("Login Successful");
    }
    else{
      alert("Login Failed");
    }
  }
  return(
      <div className="layout">
      <h1>Login Page</h1>
      <div className="box-username">
      <input type="text" onChange= {(e)=>{setUsername(e.target.value)}} placeholder="Username" />
      </div>
      <input type="text" onChange={(e)=>{setPassword(e.target.value)}} placeholder="Password" />
      <button onClick={handleLogin}>Login</button>
    </div>
)
};
export default App;

/**
import React, {useState} from 'react';
const App = () => { 
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  var uName = "Siddharth";
  var pWord = "1234";
  function handleLogin() {
    if(username === uName && password === pWord){
      alert("Login Successful");
    }
    else{
      alert("Login Failed");
    }
  }
  return(
      <div>
      <h1>Login Page</h1>
      <input type="text" onChange= {(e)=>{setUsername(e.target.value)}} placeholder="Username" />
      <input type="text" onChange={(e)=>{setPassword(e.target.value)}} placeholder="Password" />
      <button onClick={handleLogin}>Login</button>
    </div>
)
};
export default App;
 */


/**
 * 
 * function
 * Siddharth -> Grocery Store -> A 1l milk and 1/2kg onions
 * function goToGroceryStore(){
 *  1. Go to grocery store 
 *  2. Buy 1l milk and 1/2kg onions
 *  3. Bring it back home
 * }
 * 
 * 
 * 
 * setter
 * child was born and has no name ->  it is a child and setting him a name Siddharth.
 */