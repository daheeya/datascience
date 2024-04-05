package ch32.HandsOn;

import ch26.Pet;

import java.security.spec.ECField;

public class AppUI {

    private String ram;
    private String cpu;

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public static void main(String[] args) {

        try(MyWriter myWriter = new MyWriter("sys.ini")){
            myWriter.write("ram=10m");
            myWriter.write("cpu=4core");
        }catch (Exception e){
            e.printStackTrace();
        }

        var app = new AppUI();
        try(MyReader myReader = new MyReader("sys.ini")){
            var datas = myReader.getData();
            // datas.stream().map(data->data.split("=")) // stream 은 밖에 있는 애(AppUI의 변수 cpu,ram이런거)를 못 씀. 그래서 안쓰는게 맞음
            for(var d:datas){
                var valueArr = d.split("=");
                if(valueArr[0].equals("ram")) app.setRam(valueArr[1]);
                else app.setCpu(valueArr[1]);
//                for(int i =0;i<valueArr.length;i++){
//                    if(valueArr[i].equals("cpu")) app.setCpu(valueArr[i+1]);
//                    if(valueArr[i].equals("ram")) app.setRam(valueArr[i+1]);
//                }
            }

            System.out.println(datas);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(app);
    }

    @Override
    public String toString() {
        return "AppUI{" +
                "ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}
