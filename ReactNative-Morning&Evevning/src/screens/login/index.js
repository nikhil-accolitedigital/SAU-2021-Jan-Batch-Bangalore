import React, {useEffect, useState} from "react";
import { Text, TextInput, View,Button, TouchableOpacity } from "react-native";

import AsyncStorage from "@react-native-community/async-storage";


const Login = ({ navigation }) => {
    
    
const [username,setUserName] = useState("");


const checkAuth=()=>{
    const username = AsyncStorage.getItem("username");
    console.log(username);
    if(username)
     {
       navigation.navigate("ViewNotes");
     }
     else{
      console.log("Wrong credentials!!");
       navigation.navigate("Login");
     }
}




useEffect(() => {
        checkAuth();
    }, []);



const login=async()=>{
await AsyncStorage.setItem("username",username);
console.log(username);
navigation.navigate("ViewNotes");
} 
    return (
        <View style={{padding : "10%",width :"100%", height : "100%" ,justifyCOntent : "center",
        alignSelf : "center", alignContent :"center", alignItems:"center"}}>

            
            <TextInput placeholder={"Enter the Username"}
             style={{height :42 , width: "80%", borderBottomWidth : 2}} onChangeText={(username) => setUserName(username)}  />
            
            
            <TextInput placeholder={"Enter the password"}
             style={{height :42 , width: "80%", borderBottomWidth : 2, marginTop : "10%"}}/>

            <View style={{marginTop : "40%", width : "80%"}}>
                <TouchableOpacity style={{borderWidth : 1 ,height : 42, width: "80%",
                justifyCOntent :"center" , alignItems: "center",borderRadius: 40,
                backgroundColor : "black", alignSelf : "center", textAlign :"center"}}>

                <Button color="black"title ="Login" onPress={login} />
                </TouchableOpacity>
                </View>
        </View>
    )

}

export {Login};





















