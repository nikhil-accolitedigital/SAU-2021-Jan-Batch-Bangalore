import React , {useEffect, useState} from  'react';
import {Text,View,FlatList,Button} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import { AddNotes } from '../AddNotes';
import AsyncStorage from "@react-native-community/async-storage";

function ViewNotes({navigation}) {

const [notes,setNotes] = useState([]);

useEffect(()=>{
    AsyncStorage.setItem("Notes",notes);
},[notes])



const addNote= (note)=>{
note.id=notes.length+1;
setNotes([note,...notes])
}





const deleteNote =(note) =>{
console.log(note);
setNotes(notes.filter((i)=> i.id !== note.id));
}


 return(
     <View style={{flex: 1,
        backgroundColor: '#FFFFFF',
        paddingVertical: 20,
        paddingHorizontal: 10}}>
      
         {
         
         notes.length === 0 ?(<View style={{alignItems: 'center',
        justifyContent: 'center',
        flex: 1}}>
      <Text style={{fontSize: 20}}> No notes Available</Text>
      </View>) : (
        <FlatList data={notes}  
        renderItem= {({item}) =>{ return(
            <View>
            <Text style={{paddingTop: 3,
        paddingLeft: 15,
        paddingRight: 15,
        paddingBottom: 2,
        paddingTop: 10,
        fontSize: 14,
        borderRadius:10,
        fontWeight: 'bold',
        textAlign:'center',

        backgroundColor: '#87cefa'}}>{item.noteTitle}</Text>
            <Text style={{padding: 10,
        fontSize: 16, textAlign :'center',
        height: 50,}}>{item.noteDesc}</Text>
            <Button color="black" icon={
                            <Icon
                            name="arrow-right"
                            size={8}
                            color="white"
                            />
                            }
                           title="delete" type="clear" onPress={()=>{deleteNote(item)}}/>
            </View>
        )
        }
        }
        />
      )
    } 
    
      <Button color ="black"  
      style={{
        position: 'absolute',
        margin: 10,
        
        bottom: 10}} 
        title="Add Note" onPress={()=>navigation.navigate("AddNotes",{addNote:addNote})}></Button>
     </View>
 );
}

export {ViewNotes}