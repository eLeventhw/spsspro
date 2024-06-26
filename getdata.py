import pandas as pd
import sys
def get_data(path):
    if(path[-3:]=='csv'):
        df=pd.read_csv(path)
    elif(path[-4:]=='xlsx'):
        df=pd.read_excel(path)
    for col in df.columns:
        print(col+',',end='')
if __name__ == '__main__':
    get_data(sys.argv[1])