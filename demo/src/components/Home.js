import React, { Component } from 'react';

class Home extends Component{
    constructor(props){
        super(props)
        this.state={
            title:'Home组件',
            userInfo:{
                name:'wusi',
                age:30,
            }
        }
    }

    render(){
        return (
            <div>
                <h1>{this.state.title}</h1>
                <p>名字：{this.state.userInfo.name}</p>
                <p>年龄：{this.state.userInfo.age}</p>
            </div>
        )
    }
}
export default Home;