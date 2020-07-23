import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

void main() => runApp(MaterialApp(
      home: Home(),
    ));

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('My first app'),
        centerTitle: true,
        backgroundColor: Colors.red[600],
      ),
      body: Center(
        child: Image(
          image: AssetImage('assets/background.jpg'),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Text(':3'),
        onPressed: () {},
        backgroundColor: Colors.greenAccent,
      ),
    );
  }
}
