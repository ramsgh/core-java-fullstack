package com.example.corejava.service;
import com.example.corejava.domain.Product;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.*;
public final class CsvProductService {
 public List<Product> importFromCsv(Path path) throws IOException { List<Product> result=new ArrayList<>(); try(BufferedReader r=Files.newBufferedReader(path)){String line=r.readLine(); while((line=r.readLine())!=null){String[] p=line.split(","); result.add(new Product(Long.parseLong(p[0]),p[1],new BigDecimal(p[2]),Integer.parseInt(p[3])));}} return result; }
 public void export(Path path,List<Product> products)throws IOException {List<String> lines=new ArrayList<>();lines.add("id,name,price,stock");products.forEach(p->lines.add(String.join(",",p.id().toString(),p.name(),p.price().toPlainString(),Integer.toString(p.stock()))));Files.write(path,lines);}
}
