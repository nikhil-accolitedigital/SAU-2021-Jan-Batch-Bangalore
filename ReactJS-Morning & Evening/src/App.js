import React from 'react';
import logo from './logo.svg';
import './App.css';
import ListItems from './ListItems'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faTrash } from '@fortawesome/free-solid-svg-icons'

library.add(faTrash)

class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      items:[],
      currentItem:{
        text:'',
        key:'',
        checked: false
      }
    }
    this.addItem = this.addItem.bind(this);
    this.handleInput = this.handleInput.bind(this);
    this.deleteItem = this.deleteItem.bind(this);
   // this.setUpdate = this.setUpdate.bind(this);
  }
  addItem(e){
    e.preventDefault();
    const newItem = this.state.currentItem;
    console.log(newItem);
    if(newItem.text !==""){
      const items = [newItem,...this.state.items];
      console.log(items);
    this.setState({
      items: items,
      currentItem:{
        text:'',
        key:'',
        checked : false

      }
    })
    }
  }
  handleInput(e){
    this.setState({
      currentItem:{
        text: e.target.value,
        key: Date.now(),
        checked :false
      }
    })
  }
  deleteItem(key){
    const filteredItems= this.state.items.filter(item =>
      item.key!==key);
    this.setState({
      items: filteredItems
    })

  }

  setCompleted(key){
    console.log("items:"+this.state.items);
    var items = [...this.state.items];
    
    var targetIndex = -1;
    for(let i=0;i<items.length;i++){
      if(items[i].key===key)
      {
        targetIndex = i;
        break;
      }
    }
    
    var targetObj = items[targetIndex];
    targetObj.checked=true;
    if(targetIndex>-1){
      for(let i=targetIndex;i<items.length;i++){
        items[i] = items[i+1];
      }
      items[items.length-1] = targetObj;
    }
    console.log(items);

    this.setState({
      items
    })
  }
 render(){
  return (
    <div className="head1">
      
      <div className="head">
        <h1>Hey There!! Whats your plan for Today :)</h1>
        </div>
    <div className="App">
      <br></br>
      <header>

        <form id="to-do-form" onSubmit={this.addItem}>
          <input type="text" placeholder="Enter your task here" className ="task"value= {this.state.currentItem.text} onChange={this.handleInput}></input>
          <br></br><br></br>
    
          <button type="submit" className="button">Add</button>
        </form>
        <br></br>
        <p>{this.state.items.text}</p>
        





          <ListItems items={this.state.items} deleteItem={this.deleteItem} setUpdate={this.setUpdate} setCompleted={this.setCompleted.bind(this)}/>
        
      </header>
    </div>
    </div>
  );
 }
}


export default App;