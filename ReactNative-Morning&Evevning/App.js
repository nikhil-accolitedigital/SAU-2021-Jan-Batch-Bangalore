import React from 'react';
import { StyleSheet, Text } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import { View } from 'react-native';

import {ViewNotes,Login, AddNotes} from './src/screens/index';



const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
     <Stack.Navigator>
         <Stack.Screen name="Login"  component={Login}/>
         <Stack.Screen name="ViewNotes" component={ViewNotes} />
         <Stack.Screen name="AddNotes"  component={AddNotes}/>
    </Stack.Navigator>
   </NavigationContainer>
   )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
