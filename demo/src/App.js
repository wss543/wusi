import React, { Component } from 'react';
import logo from './assets/images/logo.svg';
import Home from './components/Home';
import News from './components/News';
import TodoList from './components/TodoList';

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* {<header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          
        </header>} */}
        <TodoList />
      </div>
    );
  }
}

export default App;
