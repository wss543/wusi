import React, { Component } from 'react';
import girl from '../assets/images/1.jpg';
import '../assets/css/index.css';

class News extends Component{
    constructor(props){
        super(props);
        this.state={
            msg:'news'
        }
    }
    render(){
        return (
            <div className='news' >
                <h2>引入图片</h2>
                <img src = {girl} ></img>
                <img src = {require('../assets/images/1.jpg')} ></img>
            </div>
        );
    }
}
export default News;