import React from 'react';
import { useState } from 'react';
import {View,Text, TextInput,Button} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';


function AddNotes({navigation,route}){

 const [noteTitle,setNoteTitle] = useState('');


 const [noteDesc,setNoteDesc] = useState('');




 function saveNote(){

  console.log(route.params);
  route.params.addNote({noteTitle,noteDesc});
  navigation.goBack();
 }

 return(    

  
    <View style={{flex: 2,
        backgroundColor: '#ffe4c4',
        paddingVertical: 10,
        paddingHorizontal: 10,
        paddingRight: 20}}>
  

    
        <TextInput placeholder="Enter Title of the Note" value={noteTitle} mode="outlined" style={{fontSize: 20,
        margin:20,
        height:40,
        width: 300,
        borderWidth:2,
        borderRadius: 10,
        borderColor:'black',}} onChangeText={setNoteTitle}/>
        <TextInput placeholder="Write your Note Description here"  value={noteDesc} mode="flat" multiline={true}  scrollEnabled={true} style={{height: 300,
        width: 300,
        margin:20,
        fontSize: 15,
        borderRadius: 15,
        backgroundColor :'white',
        borderWidth:1,
        borderColor:'black',
        justifyContent:'space-evenly',
            }}
        onChangeText={setNoteDesc}></TextInput>
        
        <Button color="black"
         icon={
         <Icon
               name="arrow-right"
               size={15}
               color="blue"
                
         />
         }

         iconRight
         title="Save" type="save" onPress={saveNote} 
         />
 
   
   </View>
   );   
}
export  {AddNotes};