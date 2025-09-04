# Pathfinding Project – COMP5017 Data Structures and Algorithms

## Overview
This project implements a **graph-based pathfinding system** in Java as part of the COMP5017 *Data Structures and Algorithms* module.  

It allows users to:
- Load a transport network from a `.csv` file (e.g., `Cornwall.csv`).
- Explore the network structure.
- Run classical pathfinding algorithms:
  - **Breadth-First Search (BFS)**
  - **Depth-First Search (DFS)**
  - **Dijkstra’s Algorithm**
  - **A* Search**

The program provides a simple **command-line interface** where users can choose an algorithm, input station names, and view results including routes and distances.

---

## Features
- **Graph Representation:** Uses an adjacency matrix to store stations and links.
- **File Input:** Reads a `.csv` file describing stations (with x/y positions) and links (with distances).
- **Assertions:** Pre- and post-condition checks to ensure program correctness.
- **Algorithms Implemented:**
  - BFS & DFS for graph traversal.
  - Dijkstra’s Algorithm for shortest path.
  - A* Algorithm (using Pythagoras distance heuristic).
- **Route Display:** Outputs the path taken and the total route length.

---

## Example CSV File
An example `Cornwall.csv` network file is provided:

```csv
station Rame 65 120
station Antony 20 100
station Cawsand 130 60
station Kingsand 160 140
station Millbrook 65 100
station Penlee 110 120
station Polbathic 20 120
station Treninnow 110 100
link Rame Penlee 48
link Rame Millbrook 25
link Millbrook Cawsand 100
link Cawsand Kingsand 100
link Kingsand Rame 110
link Millbrook Treninnow 50
link Millbrook Antony 55
link Antony Polbathic 25
link Polbathic Rame 50
