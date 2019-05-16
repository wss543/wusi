import React, { Component } from 'react';
import Storage from '../model/Storage'

class TodoList extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            list:[]
         };
    }
    addDate = (e)=>{
        if(e.keyCode===13){
            let tempList = this.state.list;
            tempList.push({
                title:e.target.value,
                checked:false,
            })
            this.setState({
                list:tempList
            })
            e.target.value=''
            Storage.set("todoList",tempList)
        }
    }

    handelChange=(key)=>{
        let tempList = this.state.list
        tempList[key].checked = !tempList[key].checked
        this.setState({
            list:tempList
        })
        Storage.set("todoList",tempList)
    }
    removeData=(key)=>{
        let tempList = this.state.list
        tempList.splice(key,1)
        this.setState({
            list:tempList
        })
        Storage.set("todoList",tempList)
    }
    componentWillMount() {
        let list = Storage.get("todoList")
        if(list){
            this.setState({
                list
            })
        }
    }
    render() {
        return (
            <div>
                <header>TodoList<input placeholder="请输入内容" onKeyUp={this.addDate} /></header>
                <h3>代办事项</h3>
                <ul>
                    {
                        this.state.list.map((value,key)=>{
                            if(!value.checked)
                                return (
                                    <li key={key}>
                                        <input type="checkbox" checked={value.checked} onChange={this.handelChange.bind(this,key)} />
                                        {value.title}
                                        <button onClick={this.removeData.bind(this,key)} >-</button>
                                    </li>
                                )
                            else return null
                        })
                    }
                </ul>
                <hr />
                <h3>已办事项</h3>
                <ul>
                    {
                        this.state.list.map((value,key)=>{
                            if(value.checked)
                                return (
                                    <li key={key}>
                                        <input type="checkbox" checked={value.checked} onChange={this.handelChange.bind(this,key)} />
                                        {value.title}
                                        <button onClick={this.removeData.bind(this,key)} >-</button>
                                    </li>
                                )
                            else return null
                        })
                    }
                </ul>
            </div>
        );
    }
}

export default TodoList;